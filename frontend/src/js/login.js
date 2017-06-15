(function() {
  var $, alert, confirm, form, jq_form, ref;

  $ = require('jquery');

  ref = require('dialog'), alert = ref.alert, confirm = ref.confirm;

  jq_form = require('jquery-form');

  form = jq_form(document)('#form');

  form.ajaxForm({
    beforeSubmit: function(data, from, options) {
      return form.find('[type=submit]').prop('disabled', true);
    },
    success: function(json, statusText, xhr, $form) {
      var callback;
      form.find('[type=submit]').prop('disabled', false);
      callback = function() {
        if (json.code === 200) {
          return global.location.href = '/';
        }
      };
      return alert(json.data, callback, callback);
    },
    fail: function(responseText, statusText, xhr, $form) {
      return console.log(responseText, statusText, xhr, $form);
    },
    dataType: 'json'
  });

}).call(this);
