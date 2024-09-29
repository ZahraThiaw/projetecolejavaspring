package sn.odc.oumar.springproject.Web.Mappers;


import java.lang.reflect.Field;

public class MapperImpl<T, Dto> implements BaseMapper<T, Dto>  {

        private final Class<T> entityClass;
        private final Class<Dto> dtoClass;

        public MapperImpl(Class<T> entityClass, Class<Dto> dtoClass) {
            this.entityClass = entityClass;
            this.dtoClass = dtoClass;
        }

        @Override
        public T toEntity(Dto dto) {
            try {
                T entity = entityClass.getDeclaredConstructor().newInstance();
                mapFields(dto, entity);
                return entity;
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de la conversion du DTO en entité", e);
            }
        }

        @Override
        public Dto toDto(T entity) {
            try {
                Dto dto = dtoClass.getDeclaredConstructor().newInstance();
                mapFields(entity, dto);
                return dto;
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de la conversion de l'entité en DTO", e);
            }
        }

        private <Source, Target> void mapFields(Source source, Target target) throws IllegalAccessException {
            Field[] sourceFields = source.getClass().getDeclaredFields();
            for (Field field : sourceFields) {
                field.setAccessible(true);
                Object value = field.get(source);
                try {
                    Field targetField = target.getClass().getDeclaredField(field.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, value);
                } catch (NoSuchFieldException ignored) {
                    // Ignore si le champ n'existe pas dans la cible
                }
            }
        }
    }

