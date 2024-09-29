package sn.odc.oumar.springproject.Web.Mappers;


import java.lang.reflect.Field;

    public interface BaseMapper<T, Dto> {
        T toEntity(Dto dto);
        Dto toDto(T entity);
    }