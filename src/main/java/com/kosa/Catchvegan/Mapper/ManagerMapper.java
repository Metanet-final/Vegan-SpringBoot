package com.kosa.Catchvegan.Mapper;

import com.kosa.Catchvegan.DTO.ReserveDTO;
import com.kosa.Catchvegan.DTO.RestaurantDTO;
import org.apache.ibatis.annotations.Mapper;
import com.kosa.Catchvegan.DTO.ManagerDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerMapper {
    public RestaurantDTO restaurantmanage(int managerIdx);
    public void updaterestaurant(RestaurantDTO restaurantDTO);
    public List<ReserveDTO> reservememberlist(ReserveDTO reserveDTO);
    public void confirmstatus(ReserveDTO reserveDTO);

    public List<ManagerDTO> findAllManagers();
    public Long createManager(ManagerDTO manager);

    public void managerRole(@Param("managerIdx") Integer managerIdx);

    public ManagerDTO managerGetUserByIdAndPassword(@Param("id") String id);
    public ManagerDTO managerIdGet(@Param("id") String id);

}
