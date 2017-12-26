package com.jdtms.example.demo.controller;

//import com.jdtms.example.demo.dao.OrderDao;
import com.jdtms.example.demo.bussiness.StationBus;
import com.jdtms.example.demo.bussiness.impl.StationBusImpl;
import com.jdtms.example.demo.model.Order;
//import com.mysql.jdbc.StringUtils;
import com.jdtms.example.demo.model.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: nyh
 * \* Date: 17-10-30
 * \* Time: 上午11:42
 * \* To change this template use File | Settings | File Templates.
 * \* Description: Base controller, control index
 * \
 */
@Controller
public class BaseController {

    @Autowired
    private StationBus stationBus;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(HttpServletRequest request) {
        double[][] result = {{121.20, 31.28},{121.40, 30.98},{121.62, 31.20},{121.61, 31.29}};
        request.setAttribute("stations", result);
        return "index";
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }
//    @GetMapping("/compute")
// beginlng=121.20&beginlat=31.28&
// endlng=121.61&endlat=31.29&
// stonelng=121.40&stonelat=30.98&
// sttwolng=121.62&sttwolat=31.20
    @RequestMapping(value = "/compute", method=RequestMethod.GET)
    public String compute(HttpServletRequest request,
                          @Param("beginlng") String beginlng, @Param("beginlat") String beginlat,
                          @Param("endlng") String endlng, @Param("endlat") String endlat,
                          @Param("stonelng") String stonelng, @Param("stonelat") String stonelat,
                          @Param("sttwolng") String sttwolng, @Param("sttwolat") String sttwolat) {
        String[][] stations = stationBus.compute(beginlng, beginlat, endlng, endlat,
                stonelng, stonelat, sttwolng, sttwolat);
        request.setAttribute("stations", stations);
        return "index";
    }

    /*@PostMapping("/save")
    public @ResponseBody Map<String, Object> save(@RequestBody Order order) {
        Map<String, Object> result = new HashMap<>();
        if (StringUtils.isNullOrEmpty(order.id))
            order.id = orderDao.insert(order);
        else {
            orderDao.update(order);
        }
        result.put("id", order.id);
        return result;
    }

    @PostMapping("/get")
    public @ResponseBody Object get(String id) {
        return orderDao.get(id);
    }

    @PostMapping("/findAll")
    public @ResponseBody Object findAll() {
        return orderDao.findAll();
    }

    @PostMapping("/delete")
    public @ResponseBody
    Map<String, Object> delete(String id) {
        Map<String, Object> result = new HashMap<>();
        orderDao.delete(id);
        result.put("id", id);
        return result;
    }*/
}
