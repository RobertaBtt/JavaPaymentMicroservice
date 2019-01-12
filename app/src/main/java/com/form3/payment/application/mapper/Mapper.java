package com.form3.payment.application.mapper;

import io.reactivex.Single;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO <--> Model mapper interface
 * <p>
 *
 * @param <M> Model type
 * @param <D> DTO type
 */
public abstract class Mapper<M, D> {

    public Single<D> toSingleDto(M model) {
        return Single.fromCallable(() -> toDto(model));
    }

    public D toDto(M model) {
        if (model == null) {
            return null;
        } else {
            return dtoOf(model);
        }
    }

    public M toModel(D dto) {
        if (dto == null) {
            return null;
        } else {
            return modelOf(dto);
        }
    }

    public <MODEL, DTO> List<DTO> toDtoList(List<MODEL> models, Mapper<MODEL, DTO> mapper) {
        if (models == null) {
            return null;
        } else {
            return models.stream().map(mapper::toDto).collect(Collectors.toList());
        }
    }

    public <MODEL, DTO> List<MODEL> toModelList(List<DTO> models, Mapper<MODEL, DTO> mapper) {
        if (models == null) {
            return null;
        } else {
            return models.stream().map(mapper::toModel).collect(Collectors.toList());
        }
    }

    public abstract M modelOf(D dto);

    public abstract D dtoOf(M model);

}
