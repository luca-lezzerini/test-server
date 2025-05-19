package al.polis.appserver.mapper;

import al.polis.appserver.dto.TeacherDto;
import al.polis.appserver.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CourseMapper.class})
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDto toDto(Teacher entity);

    Teacher toEntity(TeacherDto dto);

    List<TeacherDto> toDtoList(List<Teacher> entities);

    List<Teacher> toEntityList(List<TeacherDto> dtos);

}
