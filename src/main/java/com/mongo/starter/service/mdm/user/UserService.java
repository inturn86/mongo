package com.mongo.starter.service.mdm.user;

import com.mongo.starter.define.common.ECRUDMode;
import com.mongo.starter.manager.util.ModelMapperUtils;
import com.mongo.starter.service.common.MongoCommonService;
import com.mongo.starter.service.mdm.department.DepartmentEntity;
import com.mongo.starter.service.mdm.department.repository.DepartmentRepository;
import com.mongo.starter.service.mdm.user.dto.UserDTO;
import com.mongo.starter.service.mdm.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService extends MongoCommonService<String, UserEntity, UserRepository> {

	@Transactional
	public void saveUserCRUDList(List<UserEntity> userList) {
		for(var user : userList){
			//R은 skip
			if(ECRUDMode.C.getCode().equals(user.getCdcMetaOp())) {
				this.save(user);
			}
			else if(ECRUDMode.U.getCode().equals(user.getCdcMetaOp())) {
				this.patch(user);
			}
			else if(ECRUDMode.D.getCode().equals(user.getCdcMetaOp())) {
				this.delete(user);
			}
		}
	}

	public List<UserEntity> getUserList() {
		return super.getList();
	}

	public List<UserEntity> getUserList(UserEntity dto) {
		return super.getList(dto);
	}

	public List<UserEntity> getUserList(UserEntity dto, Sort sort) {
		return super.getList(dto, sort);
	}

	public Page<UserEntity> getUserPagingList(UserEntity dto, Pageable paging) {
		return super.getPagingList(dto, paging);
	}

	public Page<UserEntity> getUserPagingListBySort(UserEntity dto, Pageable paging) {
		return super.getPagingListBySort(dto, paging, paging.getSort());
	}

	//TODO - DTO로 변환하는 부분 확인.
//	public List<UserDTO> getUserList(UserDTO dto) {
//		return getList(dto);
//	}
}