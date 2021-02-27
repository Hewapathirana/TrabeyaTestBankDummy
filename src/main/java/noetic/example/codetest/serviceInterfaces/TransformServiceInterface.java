package noetic.example.codetest.serviceInterfaces;

/**
 * Created by DS hewapathirana.
 * Date:25/02/2020
 * Time: 10:15 PM
 */
public interface TransformServiceInterface {

    Object convertToDto(Object entity, String dtoClassName) throws ClassNotFoundException;

    Object convertToEntity(Object dto, String entityClassName) throws ClassNotFoundException;

    Object convertToDtoList(Object entities, String entityClassName) throws ClassNotFoundException;

    Object convertToDtoHashSet(Object entities, String dtoClassName) throws ClassNotFoundException;
}
