package com.example.rest.mapper;


import com.example.rest.model.Comment;
import com.example.rest.web.model.request.UpsertCommentRequest;
import com.example.rest.web.model.response.CommentResponse;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CommentMapper {

    Comment upsertRequestToComment(UpsertCommentRequest request);

    @Mapping(source = "user.username", target = "username")
    CommentResponse commentToResponse(Comment comment);

}
