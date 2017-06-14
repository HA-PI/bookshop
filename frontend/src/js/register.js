(function() {
  var $, alert, confirm, form, jq_form, ref;

  $ = require('jquery');

  ref = require('dialog'), alert = ref.alert, confirm = ref.confirm;

  jq_form = require('jquery-form');

  form = jq_form(document)('#form');

  form.ajaxForm({
    beforeSubmit: function(data, from, options) {
      if (data.find(function(a) {
        return a.name === 'password';
      }).value !== data.find(function(a) {
        return a.name === 'pwd-again';
      }).value) {
        alert('两次密码不正确');
        return false;
      }
      return form.find('[type=submit]').prop('disabled', true);
    },
    success: function(json, statusText, xhr, $form) {
      form.find('[type=submit]').prop('disabled', false);
      return alert(json.data);
    },
    fail: function(responseText, statusText, xhr, $form) {
      return console.log(responseText, statusText, xhr, $form);
    },
    dataType: 'json'
  });

}).call(this);
