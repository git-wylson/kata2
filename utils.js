"use strict";
angular.module("utilsMdl")
  .factory('utils', ['$window', '$timeout', '$q', /*'config',*/ function ($window, $timeout, $q /*, config*/) {

    // mode debug
    var verbose = {};
    // attente
    var waitForSomeTime = function (milliseconds) {
      // attente asynchrone de milliseconds milli-secondes
      var task = $q.defer();
      $timeout(function () {
        task.resolve(true);
      }, milliseconds);
      // on retourne la tâche
      return task;
    };

    // affichage de la représentation Json d'un objet
    function debug(message, data) {
      if (verbose.on) {
        var text = data ? message + " : " + angular.toJson(data) : message;
        console.log(text);
      }
    }

    // analyse des erreurs dans la réponse du serveur JSON
    function getErrors(data) {
      // data {err:n, messages:[]}, err!=0
      // erreurs
      var errors = [];
      // code d'erreur
      var err = data.error;
      switch (err) {
        case -1:
          // document non trouvé
          errors.push('common.error.server.inactive');
          break;
        case 2:
          // not authorized
          errors.push('not_authorized');
          break;
        case 3:
          // forbidden
          errors.push('forbidden');
          break;
        case 4:
          // erreur locale
          errors.push('not_http_error');
          break;
        case 6:
          // document non trouvé
          errors.push('not_found');
          break;
        default:
          // autres cas
          errors = data.messages;
          break;
      }
      // si pas de msg, on en met un
      if (!errors || errors.length == 0) {
        errors = ['common.error.unknown'];
      }
      // on rend la liste des erreurs
      return errors;
    }

    function setSession(key, value) {
      if ($window.Storage) {
        $window.sessionStorage.setItem(key, value);
        return true;
      } else {
        return false;
      }
    }

    function getSession(key) {
      if ($window.Storage) {
        return $window.sessionStorage.getItem(key);
      } else {
        return false;
      }
    }

    function removeSession(key) {
      if ($window.Storage) {
        return $window.sessionStorage.removeItem(key);
      } else {
        return false;
      }
    }

    function getSessionSize() {
      if ($window.Storage) {
        return $window.sessionStorage.length;
      }
      return false;
    }

    // instance du service
    return {
      waitForSomeTime: waitForSomeTime,
      debug: debug,
      getErrors: getErrors,
      verbose: verbose,
      setSession: setSession,
      getSession: getSession,
      removeSession: removeSession,
      getSessionSize: getSessionSize
    };
  }]);
