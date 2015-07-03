ngapp.controller('profileController', function($scope, userService){
    $scope.user = { "name" : "daniel"};
    $scope.applicationName = "Bite V2";
    $scope.init = function(){
        userService.getUsers().success(function(data){
            $scope.user = data;
        });
    }();
});