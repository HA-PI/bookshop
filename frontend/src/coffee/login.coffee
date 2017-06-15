$ = require 'jquery'
{alert, confirm} = require 'dialog'
jq_form = require 'jquery-form';
form = jq_form(document)('#form')

form.ajaxForm(
  beforeSubmit: (data, from, options) ->
    form.find('[type=submit]').prop('disabled', true);
  success: (json, statusText, xhr, $form) ->
    form.find('[type=submit]').prop('disabled', false);
    callback = -> global.location.href = '/' if json.code is 200
    alert json.data, callback, callback
  fail: (responseText, statusText, xhr, $form) ->
    console.log responseText, statusText, xhr, $form
  dataType: 'json'
);