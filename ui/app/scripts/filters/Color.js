'use strict';

angular.module('vin.io')
    .filter('color', function () {

        return function (bottles, color) {

            if (!color) {
                return bottles;
            }

            var filteredBottles = [];

            angular.forEach(bottles, function (bottle) {
                if (bottle.color === color) {
                    filteredBottles.push(bottle);
                }
            });

            return filteredBottles;
        };
    });