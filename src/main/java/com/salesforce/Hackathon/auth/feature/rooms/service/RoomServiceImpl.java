//package com.salesforce.Hackathon.auth.feature.rooms.service;
//
//import com.salesforce.Hackathon.auth.feature.rooms.dto.request.GenerSearchDto;
////import com.salesforce.Hackathon.auth.feature.rooms.dto.request.RoomDto;
//import com.salesforce.Hackathon.auth.feature.rooms.dto.response.RoomResponseDto;
//import com.salesforce.Hackathon.auth.feature.rooms.entity.Room;
//import com.salesforce.Hackathon.generic.payload.request.GenericSearchDto;
//import com.salesforce.Hackathon.generic.repository.AbstractRepository;
//import com.salesforce.Hackathon.generic.service.AbstractService;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import jakarta.persistence.criteria.Predicate;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class RoomServiceImpl extends AbstractService<Room, RoomDto, GenerSearchDto> implements RoomService {
//
//    public RoomServiceImpl(AbstractRepository<Room> repository) {
//        super(repository);
//    }
//
//    @Override
//    protected RoomResponseDto convertToResponseDto(Room room) {
//        if (room == null) return null;
//
//        RoomResponseDto dto = new RoomResponseDto();
//        dto.setId(room.getId());
//        dto.setName(room.getName());
//        dto.setCapacity(room.getCapacity());
//        dto.setAmenities(room.getAmenities());
//        return dto;
//    }
//
//    @Override
//    protected Room convertToEntity(RoomRequestDto roomRequestDto) throws IOException {
//        if (roomRequestDto == null) return null;
//
//        Room room = new Room();
//        room.setName(roomRequestDto.getName());
//        room.setCapacity(roomRequestDto.getCapacity());
//        room.setAmenities(roomRequestDto.getAmenities());
//        return room;
//    }
//
//    @Override
//    protected Room updateEntity(RoomRequestDto roomRequestDto, Room entity) throws IOException {
//        if (roomRequestDto == null || entity == null) return entity;
//
//        entity.setName(roomRequestDto.getName());
//        entity.setCapacity(roomRequestDto.getCapacity());
//        entity.setAmenities(roomRequestDto.getAmenities());
//        return entity;
//    }
//
//    @Override
//    protected Specification<Room> buildSpecification(GenerSearchDto searchDto) {
//        return (root, query, criteriaBuilder) -> {
//            if (searchDto == null) {
//                return criteriaBuilder.conjunction();
//            }
//
//            List<Predicate> predicates = new ArrayList<>();
//
//            if (searchDto.getKeyword() != null && !searchDto.getKeyword().isEmpty()) {
//                String likePattern = "%" + searchDto.getKeyword().toLowerCase() + "%";
//                predicates.add(
//                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), likePattern)
//                );
//            }
//
//            if (searchDto.getMinCapacity() != null) {
//                predicates.add(
//                        criteriaBuilder.greaterThanOrEqualTo(root.get("capacity"), searchDto.getMinCapacity())
//                );
//            }
//
//            if (searchDto.getMaxCapacity() != null) {
//                predicates.add(
//                        criteriaBuilder.lessThanOrEqualTo(root.get("capacity"), searchDto.getMaxCapacity())
//                );
//            }
//
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        };
//    }
//}
