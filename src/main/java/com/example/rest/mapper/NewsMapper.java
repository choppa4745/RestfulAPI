package com.example.rest.mapper;

import com.example.rest.model.News;
import com.example.rest.web.model.request.UpsertNewsRequest;
import com.example.rest.web.model.response.NewsResponse;
import com.example.rest.web.model.response.BriefNewsResponse;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@DecoratedWith(NewsMapperDelegate.class)
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface NewsMapper {

    News upsertRequestToNews(UpsertNewsRequest request);

    @Mapping(source = "author.username", target = "username")
    BriefNewsResponse newsToBriefResponse(News news);

    @Mapping(source = "author.username", target = "username")
    NewsResponse newsToResponse(News news);

}
