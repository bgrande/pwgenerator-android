'use strict';

var saveSettings = function (settings) {
    androidSave(settings);
};

// let the application set the saved settings
// getOptionSettings(JSON.parse(items.settings));

on($('cancel-options'), 'click', function() {
    androidCancel();
});

var androidCancel = function () {
    Android.cancelOptions();

};

var androidSave = function (settings) {
    Android.saveOptions(JSON.stringify(settings));
};