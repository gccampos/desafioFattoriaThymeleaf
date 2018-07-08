var application = angular.module('application', []);


application.controller('ProdutoController', function ($http, $scope) {
    $scope.listarProduto = {};

    $scope.saveUser = function () {
        $http.post('/listarProduto', $scope.produto).then(success, failed);
        function success(response) {
            $scope.updateProduto();
        };

        function failed(response) {
            console.log(response);
            alert('Error : ' + response);
        };

    };


    $scope.deletarProduto = function (x) {
        $http.delete('/listarProduto' + x.produtoId).then(success, failed);
        function success(success) {
            $scope.updateProduto();
        };

        function failed(response) {
            console.log(response);
            alert('Error : ' + response);
        };
    };

    $scope.updateProduto = function () {
        $http.get('/listarProduto').then(success, failed);

        function success(response) {
            $scope.listarProduto = response.data;
            console.log($scope.listarProduto);
        };

        function failed(response) {
            console.log(response);
            alert('Error : ' + response);
        };
    };
    
    $scope.getProduto = function (x) {
        $http.get('/listarProduto' + x.ProdutoId).then(success, failed);

        function success(response) {
            $scope.produto = response.data;
            console.log($scope.produto);
        };

        function failed(response) {
            console.log(response);
            alert('Error : ' + response);
        };
    };

    $scope.updateProduto();
});

