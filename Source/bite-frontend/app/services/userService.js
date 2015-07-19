ngapp.factory('userService', function($http,dataConfig) {
    return {
        getUsers: function(){
            return $http.get(dataConfig.urlBase+"users");
        },

        addUser: function(userObj){
            return $http.post(dataConfig.urlBase+"user",userObj);
        }
    }
})