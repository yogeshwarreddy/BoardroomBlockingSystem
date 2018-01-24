angular.module("index").config(function ($routeProvider, $locationProvider) {
  $routeProvider
    // route for the home page
    .when('/', {
      templateUrl: 'partials/homepage.html',
      controller: 'homeController'
    })
    // route for the about page
    .when('/admin', {
      templateUrl: 'partials/admin.html',
      controller: 'adminController'
    })
    // route for the requests page
    .when('/requests', {
      templateUrl: 'partials/requests.html',
      controller: 'requestsController'
    })
    // route for the login pagenyyt
    .when('/login', {
      templateUrl: 'partials/login.html',
      controller: 'loginController'
    })
    // route for the request detail page
    .when('/request/:id', {
      templateUrl: 'partials/request.html',
      controller: 'requestController'
    })
    // route for the room detail page
    .when('/room:id', {
      templateUrl: 'partials/room.html',
      controller: 'roomController'
    })      //route from logout to homepage
    .when('/logout', {
      templateUrl: 'partials/login.html',
      controller: 'logoutController'
    });
  $locationProvider.html5Mode({
    enabled: false,
    requireBase: false
  });
}).run(function ($rootScope, $location, auth, $http) {
  $rootScope.loggedIn = false;
  $rootScope.$on("$routeChangeStart", function (event, next, current) {
    if (next == "/login" && auth.isUserLoggedIn()) {
      $location.path("/");
    }
    else if (!auth.isUserLoggedIn()) {
      $location.path("/login");
      event.preventDefault();
    }
  });
  $rootScope.logout = function () {
    $http.get("/api/logout").then(function (response) {
      localStorage.clear();
      $rootScope.loggedIn = false;
      location.path("/login");
    }).catch(function (error) {

    });

  }
});