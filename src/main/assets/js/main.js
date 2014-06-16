'use strict';

var generatorFactory = function (settings, domainname) {
    var domainService = Object.create(DomainService).init(DEFAULT_SETTINGS.serviceExceptions, domainname);

    return Object.create(Generator).init(settings, domainService);
};

var generatePw = function (settings) {
    var generator = generatorFactory(settings, $('domain').value);
    $('word').value = generator.generatePassword($('passphrase').value, $('service').value);
};

var settings = DEFAULT_SETTINGS; // @todo must be loaded from android db

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
});