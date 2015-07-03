ngapp.config(function($routeProvider){
   $routeProvider.when(
       '/profile', {
           templateUrl : 'app/views/profile/profileView.html',
           controller : 'profileController'
       }
   )
       .when(
       '/', {
           templateUrl : 'app/views/home/homeView.html',
           controller : 'homeController'
       }
   )
});