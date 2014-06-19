'use strict';

(function () {
    var settings = Android.loadOptions(),
        mergedSettings = Helper.mergeObject(DEFAULT_SETTINGS, JSON.parse(settings));

    getOptionSettings(mergedSettings);

    $('servicename').disabled = 'disabled';
    $('autosend').disabled = 'disabled';
})();


var saveSettings = function (settings) {
    Android.saveOptions(JSON.stringify(settings));
};

var cancelOptions = function () {
    Android.cancelOptions();
};