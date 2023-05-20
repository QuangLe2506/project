package vn.com.devmaster.services.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.services.constants.PageConstants;
import vn.com.devmaster.services.domain.enums.RoleEnum;
import vn.com.devmaster.services.service.UserService;
import vn.com.devmaster.services.service.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserResources {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findByKeyword(@RequestParam("keyword") String keyword, Pageable pageable) {
        Page<UserDTO> page = userService.findByKeyWord(keyword, pageable);
        HttpHeaders headers = new HttpHeaders();
        headers.add(PageConstants.TOTAL_PAGE, String.valueOf(page.getTotalElements()));
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @GetMapping("/role")
    public UserDTO getByRole(@RequestParam("role")RoleEnum role){
        return userService.getByRole(role);
    }


    @PostMapping("/create")
    public void create(@RequestBody UserDTO userDTO){
        userService.create(userDTO);
    }

    @PostMapping("/update")
    public void update(@RequestParam("id") Long id, UserDTO userDTO){
        userService.update(id, userDTO);
    }

}
