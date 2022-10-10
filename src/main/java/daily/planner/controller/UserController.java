package daily.planner.controller;

import daily.planner.controller.dto.user.UserPatchDto;
import daily.planner.controller.dto.user.UserResponseDto;
import daily.planner.controller.mapper.UserMapper;
import daily.planner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static daily.planner.controller.mapper.UserMapper.mapUserToUserResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(mapUserToUserResponseDto(userService.findById(id)));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok(userService.findAll().stream()
                .map(UserMapper::mapUserToUserResponseDto)
                .toList());
    }

    @PatchMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id or hasAuthority('ADMIN')")
    public ResponseEntity<UserResponseDto> patchUser(@RequestBody UserPatchDto userPatchDto, @PathVariable Long id) {
        return ResponseEntity.ok(mapUserToUserResponseDto(userService.update(userPatchDto, id)));
    }

    @PatchMapping("/{id}/image")
    @PreAuthorize("#id == authentication.principal.id or hasAuthority('ADMIN')")
    public ResponseEntity<UserResponseDto> patchUserImage(@RequestParam MultipartFile multipartImage, @PathVariable Long id) {
        return ResponseEntity.ok(mapUserToUserResponseDto(userService.updateUserImage(multipartImage, id)));
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getUserImage(@PathVariable Long id) {
        byte[] image = userService.findById(id).getImage();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image.jpg\"")
                .body(image);
    }

    @GetMapping("/defaultImage")
    public ResponseEntity<byte[]> getUserDefaultImage() {
        byte[] defaultImage = userService.getDefaultImage();
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image.jpg\"")
                .body(defaultImage);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id or hasAuthority('ADMIN')")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

}