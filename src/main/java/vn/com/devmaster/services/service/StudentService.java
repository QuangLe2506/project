package vn.com.devmaster.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.domain.Khoa;
import vn.com.devmaster.services.domain.Student;
import vn.com.devmaster.services.repository.BuildingRepository;
import vn.com.devmaster.services.repository.KhoaRepository;
import vn.com.devmaster.services.repository.StudentRepository;
import vn.com.devmaster.services.service.dto.StudentDTO;
import vn.com.devmaster.services.service.mapper.StudentMapper;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final BuildingRepository buildingRepository;
    private final KhoaRepository khoaRepository;

    @Transactional
    public void create(StudentDTO studentDTO){
        Student student = studentMapper.toEntity(studentDTO);
        Building building = buildingRepository.findById(studentDTO.getBuildingId()).orElse(null);
        if (building == null) throw new RuntimeException("Không tìm thấy building");
        student.setBuildingId(building);
        Khoa khoa = khoaRepository.findById(studentDTO.getKhoaId()).orElse(null);
        if (khoa == null) throw new RuntimeException("Không tìm thấy khoa");
        student.setKhoaId(khoa);
        studentRepository.save(student);
    }

    @Transactional
    public void update(Long id, StudentDTO studentDTO){
        Student student = studentMapper.toEntity(studentDTO);
        student.setId(id);
        studentRepository.save(student);
    }
}
