ngapp.controller('signupController', function($scope, userService){
    $scope.user = {};
    $scope.addUser = function(){
        userService.addUser($scope.user).success(function(){
            alert("success");
        });
    };
});