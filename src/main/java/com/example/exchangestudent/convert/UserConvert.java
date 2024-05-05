package com.example.exchangestudent.convert;

import com.example.exchangestudent.model.dto.UserDTO;
import com.example.exchangestudent.model.po.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    User dto2po(UserDTO userDTO);
}
