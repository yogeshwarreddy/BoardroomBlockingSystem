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