package services;

import entities.Route;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommonService implements ICommonService {
    @Override
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(1,"getUsers()","(GET)  /users",""));
        return routes;
    }
}
