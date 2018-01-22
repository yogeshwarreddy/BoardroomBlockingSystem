(function () {
  angular.module("index", ["ngRoute"]);
  angular.module("index").config(function ($routeProvider, $locationProvider) {
    $routeProvider
      // route for the home page
      .when('/', {
        templateUrl: 'homepage.html',
        controller: 'homeController'
      })
      // route for the about page
      .when('/admin', {
        templateUrl: 'admin.html',
        controller: 'adminController'
      })
      // route for the requests page
      .when('/requests', {
        templateUrl: 'requests.html',
        controller: 'requestsController'
      })
      // route for the login page
      .when('/login', {
        templateUrl: 'login.html',
        controller: 'loginController'
      })
      // route for the request detail page
      .when('/request/:id', {
        templateUrl: 'request.html',
        controller: 'requestController'
      })
      // route for the room detail page
      .when('/room:id', {
        templateUrl: 'room.html',
        controller: 'roomController'
      });
    $locationProvider.html5Mode({
      enabled: false,
      requireBase: false
    });
  }).run(function ($rootScope, $location, auth) {
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
  });
  angular.module("index").controller("homeController", function ($scope, $http) {
    $http.get("/helloworld/rooms").then(function (response) {
      $scope.rooms = response.data;
    }, function (response) {
      console.log("error in get rooms");
      $scope.rooms = [];
    });
    $http.get("/helloworld/requests").then(function (response) {
      $scope.requests = response.data;
      $scope.requests.forEach(request => {
        request.from_time = new Date(request.startTime).toLocaleString();
        request.to_time = new Date(request.endTime).toLocaleTimeString();
      });
    }, function (response) {
      console.log("error in get rooms");
      $scope.requests = [];
    });
  });
  angular.module("index").controller("loginController", function ($rootScope, $scope, auth, $location) {
    $scope.email;
    $scope.password;
    $scope.login = login;
    function login () {
      auth.login($scope.email, $scope.password, function () {
        $rootScope.loggedIn = true;
        $location.path("/");
      }, function () {
        Materialize.toast('Invalid Credentials!', 4000);
      });
    }
  });
  angular.module("index").controller("requestController", function ($scope, $routeParams, $http, auth) {
    $http.get("/helloworld/request/" + $routeParams.id).then(function (response) {
      $scope.request = response.data;
      console.dir(response);
    }).catch(function (error) {
      console.log("error fetching request data");
    })
    $http.get("/helloworld/rooms?branchId=" + auth.getUser().branch.id).then(
      function (response) {
        $scope.rooms = response.data;
      }
    ).catch(function (error) {
      $scope.rooms = [];
    });
  });
  angular.module("index").controller("roomController", function ($rootScope, $scope) {
  });
  angular.module("index").controller("adminController", function ($rootScope, $scope) {
  });
  angular.module("index").controller("requestsController", function ($rootScope, $scope, $http) {
    $http.get("/helloworld/requests").then(function (response) {
      $scope.requests = response.data;
      $scope.requests.forEach(request => {
        request.from_time = new Date(request.startTime).toLocaleString();
        request.to_time = new Date(request.endTime).toLocaleTimeString();
      });
    }, function (response) {
      console.log("error in get rooms");
      $scope.requests = [];
    });
  });
  angular.module("index").service("auth", function ($rootScope, $http) {
    this.isUserLoggedIn = isUserLoggedIn;
    this.currentUser;
    this.isUserAuthenticated = isUserAuthenticated;
    this.login = login;
    var auth = this;
    $rootScope.isAdmin = function () {
      return auth.isUserAuthenticated("Admin");
    }
    this.getUser = getUser;
    function getUser () {
      if (isUserLoggedIn) {
        return this.currentUser;
      }
      return null;
    }
    function isUserAuthenticated (permission) {
      if (isUserLoggedIn()) {
        for (var role of currentUser.roles) {
          if (role.role_name == permission) {
            return true;
          }
        }
      }
      return false;
    }
    function login (email, password, callback, error) {
      return $http.
        post("/helloworld/login",
        { email: email, password: password }).
        then(
        function (response) {
          localStorage.setItem("user", JSON.stringify(response.data));
          callback();
        }).catch(error);
    }
    function isUserLoggedIn () {
      if (!this.currentUser) {
        this.currentUser = JSON.parse(localStorage.getItem("user"));
      }
      if (this.currentUser) {
        $rootScope.loggedIn = true;
        return true;
      }
      return false;
    }
  });


  /*===============================================================================================
  
                  Standard js scripts
  
  ===============================================================================================*/
  $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year,
    today: 'Today',
    clear: 'Clear',
    close: 'Ok',
    closeOnSelect: false // Close upon selecting a date,
  });
  $('.timepicker').pickatime({
    default: 'now', // Set default time: 'now', '1:30AM', '16:30'
    fromnow: 0,       // set default time to * milliseconds from now (using with default = 'now')
    twelvehour: false, // Use AM/PM or 24-hour format
    donetext: 'OK', // text for done-button
    cleartext: 'Clear', // text for clear-button
    canceltext: 'Cancel', // Text for cancel-button
    autoclose: false, // automatic close timepicker
    ampmclickable: true, // make AM PM clickable
    aftershow: function () { } //Function for after opening timepicker
  });
})();