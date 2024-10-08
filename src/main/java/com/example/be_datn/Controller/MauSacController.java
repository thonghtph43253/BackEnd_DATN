package com.example.be_datn.Controller;

import com.example.be_datn.DTO.Response.ApiResponse;
import com.example.be_datn.Entity.MauSac;
import com.example.be_datn.Service.IMauSacService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mausacs")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class MauSacController {
    IMauSacService mauSacService;

    @GetMapping("")
    ApiResponse<List<MauSac>> getAllMauSacs() {
        ApiResponse<List<MauSac>> apiResponse = new ApiResponse<>();
        apiResponse.setData(mauSacService.getAllMauSac());
        return apiResponse;
    }

    @PostMapping("")
    ApiResponse<MauSac> createMauSac(@RequestBody @Valid MauSac mauSac) {
        ApiResponse<MauSac> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Cập nhật thành công màu " + mauSac.getTenMau());
        apiResponse.setData(mauSacService.createMauSac(mauSac));
        return apiResponse;
    }

    @GetMapping("/{id}")
    ApiResponse<MauSac> getMauSacById(@PathVariable Long id) {
        ApiResponse<MauSac> apiResponse = new ApiResponse<>();
        apiResponse.setData(mauSacService.getMauSacById(id));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    ApiResponse<String> deleteMauSacById(@PathVariable Long id) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(mauSacService.deleteMauSac(id));
        return apiResponse;
    }

    @PutMapping("/{id}")
    ApiResponse<MauSac> updateMauSac(@PathVariable Long id, @RequestBody @Valid MauSac mauSac) {
        ApiResponse<MauSac> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Cập nhật thành công màu sắc");
        apiResponse.setData(mauSacService.updateMauSac(id, mauSac));
        return apiResponse;
    }

}
