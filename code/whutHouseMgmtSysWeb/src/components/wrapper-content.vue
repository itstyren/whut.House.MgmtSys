<template>
  <div class="wrapper-main">
    <vue-scroll>
      <div class="wrapper-content">
        <slot name="page-header"></slot>
        <div class="layout-content">
          <slot name="page-action"></slot>
          <h1 class="page-title"
              v-if="pageTitle != ''">{{ pageTitle }}</h1>
          <slot></slot>
        </div>
        <!--<div class="layout-copy">
                2016-2017 &copy; Pear TeamConsole
            </div>-->
      </div>
    </vue-scroll>
  </div>
</template>
<script>

export default {
  props: {
    pageTitle: {
      default: ''
    },
  },
}
</script>
