'use strict';

var settings = Helper.mergeObject(DEFAULT_SETTINGS, JSON.parse(Android.loadOptions()));

var generatorFactory = function (settings, domainname) {
    var domainService = Object.create(DomainService).init(DEFAULT_SETTINGS.serviceExceptions, domainname);
    return Object.create(Generator).init(settings, domainService);
};

var generatePw = function (settings) {
    var generator = generatorFactory(settings, $('domain').value);
    $('word').value = generator.generatePassword($('passphrase').value, $('service').value);
};

on($('domain'), 'change', function () {
    var generator = generatorFactory(settings, this.value);
    $('service').value = generator.getServicename($('service').value, undefined);
});

on($('passphrase'), 'keyup', function () {
    generatePw(settings);
});

on($('service'), 'keyup', function () {
    generatePw(settings);
});

on($('show-passphrase'), 'change', function () {
    var checked = this.checked,
        type = $('passphrase').type;

    if (type === 'password' && checked) {
        $('passphrase').type = 'text';
    } else {
        $('passphrase').type = 'password';
    }
});

on($('word'), ['focus', 'click'], function (e) {
    this.select();
    Android.copyToClipboard(this.value);
});

on($('reset-form'), 'click', function (e) {
    $('generator-form').reset();
    Android.resetForm();
});