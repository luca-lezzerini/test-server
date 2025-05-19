package al.polis.appserver.mapper;

import al.polis.appserver.dto.CourseDto;
import al.polis.appserver.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {StudentMapper.class, TeacherMapper.class})
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mappings({
            @Mapping(target = "teacher.courses", ignore = true)
    })
    CourseDto toDto(Course entity);

    @Mappings({
            @Mapping(target = "teacher.courses", ignore = true)
    })
    Course toEntity(CourseDto dto);

    List<CourseDto> toDtoList(List<Course> entities);

    List<Course> toEntityList(List<CourseDto> dtos);
}
