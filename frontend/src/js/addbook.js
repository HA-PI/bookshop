(function() {
  var $, alert, alertDiv, confirm, form, jq_form, ref, showAlert;

  $ = require('jquery');

  ref = require('dialog'), alert = ref.alert, confirm = ref.confirm;

  jq_form = require('jquery-form');

  form = jq_form(document)('#form');

  form.ajaxForm({
    beforeSubmit: function(data, from, options) {
      return form.find('[type=submit]').prop('disabled', true);
    },
    success: function(arg, statusText, xhr, $form) {
      var code, data;
      data = arg.data, code = arg.code;
      form.find('[type=submit]').prop('disabled', false);
      return showAlert(data, code === 200);
    },
    fail: function(responseText, statusText, xhr, $form) {
      return console.log(responseText, statusText, xhr, $form);
    },
    dataType: 'json'
  });

  alertDiv = $('#alert');

  showAlert = function(text, success) {
    if (success == null) {
      success = true;
    }
    if (success !== true) {
      alertDiv.removeClass('alert-success').addClass('alert-danger');
    } else {
      alertDiv.removeClass('alert-danger').addClass('alert-success');
    }
    alertDiv.find('[role=text]').text(text);
    return alertDiv.fadeIn('normal');
  };

  $('#img').change(function(e) {
    var files, fr, img;
    img = $(this);
    files = $(this).prop('files');
    fr = new FileReader();
    fr.readAsDataURL(files[0]);
    return fr.onload = function(e) {
      return this.result;
    };
  });

}).call(this);
