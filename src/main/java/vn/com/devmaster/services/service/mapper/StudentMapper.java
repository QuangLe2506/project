package vn.com.devmaster.services.service.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.services.domain.Student;
import vn.com.devmaster.services.service.dto.StudentDTO;

import java.util.Collection;
import java.util.stream.Collectors;
@Component
public class StudentMapper implements EntityMapper<StudentDTO, Student> {
    @Override
    public StudentDTO toDto(Student entity) {
        StudentDTO dto = new StudentDTO();
        dto.setCode(entity.getCode());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        Student entity = new Student();
        entity.setCode(dto.getCode());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }

    @Override
    public Collection<StudentDTO> toDto(Collection<Student> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Collection<Student> toEntity(Collection<StudentDTO> dto) {
        return null;
    }
}
