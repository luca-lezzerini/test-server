package al.polis.appserver.mapper;

import al.polis.appserver.dto.StudentDto;
import al.polis.appserver.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CourseMapper.class})
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(target = "course.students", ignore = true)
    })
    StudentDto toDto(Student entity);

    @Mappings({
            @Mapping(target = "course.students", ignore = true)
    })
    Student toEntity(StudentDto dto);

    List<StudentDto> toDtoList(List<Student> entities);

    List<Student> toEntityList(List<StudentDto> dtos);

}
