(function () {
    var settings = DEFAULT_SETTINGS; // @todo must be loaded from android db

    var generatorFactory = function (settings, domainname) {
        var domainService = Object.create(DomainService).init(DEFAULT_SETTINGS.serviceExceptions, domainname),
            generator = Object.create(Generator).init(settings, domainService);
    };

    var generatePw = function () {
        var generator = generatorFactory(settings, $('domain').value);
        $('word').value = generator.generatePassword($('passphrase').value, $('service').value);;
    };

    on([$('passphrase'), $('service')], 'change', function () {
        generatePw();
    });

    on($('show-passphrase'), 'change', function () {
        var checked = this.checked;
        var type = $('passphrase').type;
        if (type === 'password' && checked) {
            $('passphrase').type = 'text';
        } else {
            $('passphrase').type = 'password';
        }
    });
})();