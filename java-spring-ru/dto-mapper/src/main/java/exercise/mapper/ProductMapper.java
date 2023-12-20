package exercise.mapper;

import org.mapstruct.*;

// BEGIN
@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class PostMapper {
    public abstract Post map(PostCreateDTO dto);
    public abstract PostDTO map(Post model);
    public abstract void update(PostUpdateDTO dto, @MappingTarget Post model);
}
// END
