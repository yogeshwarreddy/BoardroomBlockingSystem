angular.module("index").service("auth", function ($rootScope, $http) {
  this.isUserLoggedIn = isUserLoggedIn;
  this.currentUser;
  this.isUserAuthenticated = isUserAuthenticated;
  this.login = login;
  var auth = this;
  this.logout = logout;
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
      post("/api/login",
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
  function logout () {
    this.currentUser = null;
    localStorage.clear();
    $rootScope.loggedIn = false;
  }
});