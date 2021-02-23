package noetic.example.codetest.serviceInterfaces;

/**
 * Created by DS hewapathirana.
 * Date: 9/23/2019
 * Time: 7:00 PM
 */
public interface TransformServiceInterface {

    Object convertToDto(Object entity, String dtoClassName) throws ClassNotFoundException;

    Object convertToEntity(Object dto, String entityClassName) throws ClassNotFoundException;

    Object convertToDtoList(Object entities, String entityClassName) throws ClassNotFoundException;

    Object convertToDtoHashSet(Object entities, String dtoClassName) throws ClassNotFoundException;
}
