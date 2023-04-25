package com.allanAsc.MyGrowthApiChallengeV2.util;


import com.allanAsc.MyGrowthApiChallengeV2.dto.UserDto;
import com.allanAsc.MyGrowthApiChallengeV2.user.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    @Autowired
    ModelMapper modelMapper;

    public UserDto convertToUserDto(User User) {
        return modelMapper.map(User, UserDto.class);
    }

    public User convertToUserEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }
}
