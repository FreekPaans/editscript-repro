(ns editscript-test.core
  )

(require '[editscript.edit])
(require '[editscript.core :as editscript])

(def edit-source {})
(def edit-dest {:x :hello-world})

"this throws"
(let [edits (editscript.edit/get-edits
              (editscript/diff edit-source edit-dest))]
  (editscript/patch edit-source (editscript.edit/edits->script edits))
  )


"the following is also weird"

(assert (= (editscript.edit/get-edits
                        (editscript/diff {} {}))
          (editscript.edit/get-edits
                        (editscript/diff {} {})))
  "this succeeds"
  )

(def some-edits (editscript.edit/get-edits
                  (editscript/diff {} {})))

(assert (= some-edits (editscript.edit/get-edits
                        (editscript/diff {} {})))
  "this fails"
  )

