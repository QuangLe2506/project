package vn.com.devmaster.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.domain.User;
import vn.com.devmaster.services.domain.enums.RoleEnum;
import vn.com.devmaster.services.repository.BuildingRepository;
import vn.com.devmaster.services.repository.UserRepository;
import vn.com.devmaster.services.service.dto.UserDTO;
import vn.com.devmaster.services.service.mapper.UserMapper;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BuildingRepository buildingRepository;

    public Page<UserDTO> findByKeyWord(String keyword, Pageable pageable) {
        Page<User> users = userRepository.findByKeyword(keyword, pageable);
        return users.map(userMapper::toDto);
    }
    @Transactional
    public void create(UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        Building building = buildingRepository.findById(userDTO.getBuildingId()).orElse(null);
        if (building==null) throw new RuntimeException("Không tìm thấy building");
        user.setBuilding(building);
        userRepository.save(user);
    }

    @Transactional
    public void update(Long id, UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        user.setId(id);
        user.setStatus(user.getStatus());
        userRepository.save(user);
    }

    @Transactional
    public UserDTO getByRole(RoleEnum role){
        Optional<User> optionalUser = userRepository.findByRole(role);
        if (!optionalUser.isPresent()){
            throw new RuntimeException("not found");
        }
        User user = optionalUser.get();
        UserDTO userDTO = userMapper.toDto(user);
        return userDTO;
    }

}
