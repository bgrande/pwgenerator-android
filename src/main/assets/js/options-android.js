'use strict';

(function () {
    var settings = Android.loadOptions(),
        mergedSettings = Helper.mergeObject(JSON.parse(settings), DEFAULT_SETTINGS);

    getOptionSettings(mergedSettings);
})();


var saveSettings = function (settings) {
    androidSave(settings);
};

on($('cancel-options'), 'click', function() {
    androidCancel();
});

var androidCancel = function () {
    Android.cancelOptions();
};

var androidSave = function (settings) {
    Android.saveOptions(JSON.stringify(settings));
};