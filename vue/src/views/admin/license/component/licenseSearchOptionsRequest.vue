<script>
import axios from 'axios'

export default {
  data() {
    return {
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      axios
        .get('http://localhost/licenses/search')
        .then(res => {
          console.log(res.data)
          this.$emit('searchOptions', res.data)
        })
        .catch(err => {
          alert('fail')
          console.log(err)
        })
    }
  }
}
</script>
