ngapp.factory('userService', function($http,dataConfig) {
    return {
        getUsers: function(){
            return $http.jsonp(dataConfig.urlBase+"users?callback=JSON_CALLBACK");
        },

        addUser: function(userObj){
            return $http.post(dataConfig.urlBase+"user",userObj);
        }
    }
})