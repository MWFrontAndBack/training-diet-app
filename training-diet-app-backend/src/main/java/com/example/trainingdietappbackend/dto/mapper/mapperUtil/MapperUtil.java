package com.example.trainingdietappbackend.dto.mapper.mapperUtil;

import org.modelmapper.ModelMapper;

public class MapperUtil {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <S, D> D map(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

}
