"use strict";
angular.module("utilsMdl")
  .factory('dao', ['$http', '$q', '$base64', 'config', 'utils',
    function ($http, $q, $base64, config, utils) {

      // log
      utils.debug("[dao] init");

      // liste de données
      function getData(/*serverUrl, username, password,*/ urlAction, info) {
        // opération asynchrone
        var task = $q.defer();
        // url requête HTTP
        var url = /*serverUrl +*/ urlAction;
        // authentification basique
        //var basic = "Basic " + $base64.encode(username + ":" + password);
        // la réponse
        var reponse;
        // les requêtes http doivent être toutes authentifiées
        //var headers = $http.defaults.headers.common;
        //headers.Authorization = basic;
        // on fait la requête HTTP
        var promise;
        if (info) {
          promise = $http.post(url, info, {timeout: config.timeout});
        } else {
          promise = $http.get(url, {timeout: config.timeout});
        }
        promise.then(success, failure);
        // on retourne la tâche elle-même afin qu'elle puisse être annulée
        return task;

        // success
        function success(response) {
          // response.data={status:0, data:[med1, med2, ...]} ou {status:x, data=[msg1, msg2, ...]
          utils.debug("[dao] getData[" + urlAction + "] success réponse", '');
          // réponse
          var payLoad = response.data;
          reponse = response.status == 200 ? {error: 0, data: payLoad.data, pagination: payLoad.pagination} : {error: 1, messages: payLoad.data};
          // on rend la réponse
          task.resolve(reponse);
        }

        // failure
        function failure(response) {          
          // on analyse le status
          var status = response.status;
          var err;
          switch (status) {
            case 401 :
              // unauthorized
              err = 2;
              break;
            case 403:
              // forbidden
              err = 3;
              break;
            case 404:
              // not found
              err = 6;
              break;
            case 0:
              // erreur locale
              err = 4;
              break;
            case -1:
              // erreur serveur inactif
              err = -1;
              break;
            default:
              // autre chose
              err = 5;
          }
          // on rend la réponse
          task.resolve({error: err, messages: [response.statusText]});
        }
      }

      // --------------------- instance du service [dao]
      return {
        getData: getData
      }
    }]);
