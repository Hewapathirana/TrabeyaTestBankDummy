package noetic.example.codetest.serviceImpl;


import noetic.example.codetest.serviceInterfaces.TransformServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DS hewapathirana.
 * Date:25/02/2020
 * Time: 9:45 PM
 */
@Service
public class TransformServiceImpl implements TransformServiceInterface {


        @Autowired
        private ModelMapper modelMapper;

        @Override
        public Object convertToDto(Object entity, String dtoClassName) throws ClassNotFoundException {
            Object objectDto = modelMapper.map(entity, Class.forName(dtoClassName));
            return objectDto;
        }

        @Override
        public Object convertToEntity(Object dto, String entityClassName) throws ClassNotFoundException {
            Object entity = modelMapper.map(dto, Class.forName(entityClassName));
            return entity;
        }

        @Override
        public Object convertToDtoList(Object entities, String dtoClassName) throws ClassNotFoundException {
            List<Object> dtoList = new ArrayList<>();
            for (Object entity : (List) entities) {
                Object objectDto = modelMapper.map(entity, Class.forName(dtoClassName));
                dtoList.add(objectDto);
            }
            return dtoList;
        }

        @Override
        public Object convertToDtoHashSet(Object entities, String dtoClassName) throws ClassNotFoundException {
            Set<Object> dtoList = new HashSet<>();
            for (Object entity : (Set) entities) {
                Object objectDto = modelMapper.map(entity, Class.forName(dtoClassName));
                dtoList.add(objectDto);
            }
            return dtoList;
        }



}
